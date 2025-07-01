次のような Fruit.java があるとします。

Fruit.java
```
package model;

import java.io.Serializable;

public class Fruit implements Serializable {
	private String name;
	private int price;
	
	public Fruit() {}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPrice() {
		return price;
	}
}
```

そして、次のようなサーブレットを用意します。

FruitServlet.java
```
package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/FruitServlet")
public class FruitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Fruit fruit = new Fruit();
		fruit.setName("いちご");
		fruit.setPrice(700);
		HttpSession session = request.getSession();
		session.setAttribute("fruit", fruit);
		System.out.println("セッションに保存しました。");
	}
}
```

そして、fruit.jsp を webapp直下に用意します。

src/main/webapp/fruit.jsp
```
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ex.Fruit" %>
<%
Fruit fruit = (Fruit)session.getAttribute("fruit");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>fruit</title>
</head>
<body>
	<p><%= fruit.getName() %> : <%= fruit.getPrice() %></p>
</body>
</html>
```

このアプリケーションを Tomcal10.1 Java21 のランタイム環境で動作させます。

http://localhost:8080/myapp/FruitServlet

として、サーブレットを動作させたのち、サーバーを再起動させます。

そして、
http://localhost:8080/myapp/fruit.jsp
にアクセスすると、
エラーになって、fruit.jspの "fruit.getName()" の fruit が null になります。

そこで、ワークスペースの "Servers" の "Tomcat10_Java21-config" の
"context.xml" の以下のところをコメントアウトします。

```
<!-- Uncomment this to enable session persistence across Tomcat restarts -->
<!--
<Manager pathname="SESSIONS.ser" />
-->
```

これを次のようにする。

```
<!-- Uncomment this to enable session persistence across Tomcat restarts -->
<Manager pathname="SESSIONS.ser" />
```

これで、サーバーを右クリックして、"追加および除去"で配置しなおします。

こののち、サーバーを起動して

http://localhost:8080/myapp/FruitServlet

にアクセスしセッションスコープに Fruitインスタンスを保存してから、
サーバーを停止、そして起動します。

そして、次にアクセスすると、

http://localhost:8080/myapp/fruit.jsp

"いちご:700" と表示されます。

ここまでのコードでまちがいはないでしょうか？


そして、疑問なのは、"context.xml" です。

Tomcat9 のときは、context.xml は、次のようになっています。

```
<!-- Uncomment this to disable session persistence across Tomcat restarts -->
<!--
<Manager pathname="" />
-->
```

これが、Tomcat10になって、次のようになったのは、なぜなのでしょうか？

```
<!-- Uncomment this to enable session persistence across Tomcat restarts -->
<!--
<Manager pathname="SESSIONS.ser" />
-->
```



ご質問の内容について、以下の2点に分けて丁寧にお答えします。

---

## ✅ 1. **コードの妥当性について**

結論から言えば、**提供されたコードは正しく動作する内容です**。Tomcat のセッション永続化機能が有効になっている場合、以下の流れで想定通りに動きます。

### ✔ 期待通りに動く理由：

* `Fruit` クラスは `Serializable` を実装しており、Tomcat のセッション永続化対象になります。
* `FruitServlet` にて `HttpSession` に `fruit` オブジェクトを保存。
* `fruit.jsp` でセッションから `fruit` を取り出して表示。
* `context.xml` に `<Manager pathname="SESSIONS.ser" />` が設定されていれば、**サーバー再起動後もセッションが復元される**。

したがって、

* コード上の問題 → **なし**（適切）
* 再起動後のセッション復元 → **Tomcat側の設定次第**

---

## ❓ 2. **Tomcat 9 と Tomcat 10 での `context.xml` の記述の違いについて**

### ❗違いの確認：

* **Tomcat 9 の `context.xml`：**

  ```xml
  <!-- Uncomment this to disable session persistence across Tomcat restarts -->
  <!--
  <Manager pathname="" />
  -->
  ```

* **Tomcat 10 の `context.xml`：**

  ```xml
  <!-- Uncomment this to enable session persistence across Tomcat restarts -->
  <!--
  <Manager pathname="SESSIONS.ser" />
  -->
  ```

### 💡この違いの意味は？

| 内容                        | Tomcat 9            | Tomcat 10         |
| ------------------------- | ------------------- | ----------------- |
| コメントの説明                   | 永続化**を無効にする**設定     | 永続化**を有効にする**設定   |
| `pathname=""`             | 空文字 → 永続化ファイルなし（無効） | 無効にはなるがコメント内      |
| `pathname="SESSIONS.ser"` | 任意のファイル名で永続化有効      | Tomcat 10での推奨スタイル |

---

### 🔍 なぜ変更されたのか？

Tomcat 10以降では、\*\*セッション永続化は「デフォルトで無効」\*\*になり、必要なときに明示的に有効にするよう設計ポリシーが変更されています。理由は以下のとおりです：

#### ✅ 理由1：セキュリティとデータ一貫性の観点

セッションオブジェクトがシリアライズされて保存されるため、セキュリティ的なリスクや互換性の問題が生じやすい（例：アプリのコード変更後に復元できなくなるなど）。

#### ✅ 理由2：クラウド・コンテナ環境を意識した設計

再起動前提の永続セッションよりも、**ステートレス設計**や外部セッション管理（Redisなど）を推奨する流れ。

#### ✅ 理由3：意図的に有効にするスタイルへ

Tomcat 9 では「明示しなければ有効だった」が、Tomcat 10 では「**明示しなければ無効**」という設計に変更。

---

## ✅ 結論まとめ

* **コード：** 問題なし。Tomcatのセッション永続化機能を正しく利用しています。
* **Tomcat 10の `context.xml`：** セッション永続化が**デフォルトで無効**になったため、明示的に `<Manager pathname="SESSIONS.ser" />` を記述して有効化する必要があります。
* **Tomcat 9との違い：** 設定ポリシーの違い（Tomcat 9はデフォルトで有効、Tomcat 10はデフォルトで無効）による表記・コメントの意図が異なります。

---

ご希望があれば、`SESSIONS.ser` ファイルの保存場所やフォーマット、セッションオブジェクトの復元メカニズムの詳細もご説明できます。






;; 修正時刻: Tue 2025/07/01 20:34:36
