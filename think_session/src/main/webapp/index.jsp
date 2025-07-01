<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>セッションとSerializable</title>
</head>
<body>
	<h1>セッションとSerializable</h1>
	<section>
		<h2>セッションスコープのFruitインスタンス</h2>
		${fruit.name}の値段は ${fruit.price}円です。
	</section>
	<section>
		<h2>手順</h2>
		<ol>
			<li>http://localhost:8080/think_session/にアクセスする。<br />
			"の値段は です。"と表示される。</li>
			<li>次に http://localhost:8080/think_session/fruit にアクセスする。<br />
			コンソールに"セッションに保存しました"と表示される。</li>
			<li>サーバーを再起動（再開）する。<br />
			メモリに保存されていたセッションインスタンスは消去される。</li>
			<li>再度、"http://localhost:8080/think_session/にアクセスする。<br />
			すると、"いちごの値段は700円です。"と表示される。</li>
		</ol>
	</section>
	<section>
		<h2>解説</h2>
		<p>Fruit.java に Serializableインターフェースをimplementすると、<br />
		Fruitインスタンスがディスクの保存される。<br />
		サーバーが再起動すると、サーブレットコンテナが、ディスクから
		Fruitインスタンスをメモリに読み込んでいる。</p>
		<p>Fruit.java から "implements Serializable"を削除すると、<br />
		サーバーを再起動してから http://localhost:8080/think_session/ にアクセスすると、
		"いちご"と"700"は表示されない。<br />
		つまり、Fruitインスタンスはディクスから読み込まれない。</p>
		<p>以上のことは、アプリケーションスコープの場合でも同じである。</p>
		<p>リクエストスコープの場合は、リクエストスコープ自体、
		レスポンスが返された時点で消滅しているから、
		再度index.jspを表示された時はスコープの中にはFruitインスタンスは存在していない。
		</p>		
	</section>
</body>
</html>