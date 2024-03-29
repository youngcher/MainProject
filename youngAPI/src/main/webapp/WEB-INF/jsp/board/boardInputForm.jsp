<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>게시판 글 입력폼</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<style type="text/css">
main {
	width: fit-content;
	margin: 0 auto;
}

main>h3 {
	width: fit-content;
	margin: 1em auto;
	border-bottom: 3px double black;
}

form {
	padding: 1em;
	border: 1px solid black;
	border-radius: 7px;
}

div>label {
	display: inline-block;
	width: 2em;
	padding-right: 1em;
	text-align: right;
	vertical-align: top;
}

div>input {
	width: 30em;
	margin-bottom: 0.5em;
}

div>textarea {
	width: 30em;
	height: 10em;
}

form>div:last-child {
	margin: 1em auto;
	margin-bottom: 0;
	width: fit-content;
	text-align: center;
}

nav {
	width: fit-content;
	margin: 1em auto;
}

nav>a {
	text-decoration: none;
}
</style>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>
<script type="text/javascript">
	function save() {
		$.ajax({
			url : '/board/save',
			method : 'post',
			cache : false,
			data : $('#input_form').serialize(),
			dataType : 'json',
			success : function(res) {
				alert(res.saved ? '저장 성공' : res.msg);
				if (!res.saved && res.msg) {
					location.href = "/login/loginForm";
				}
			},
			error : function(xhr, status, err) {
				alert('Error:' + err);
			}
		});
		return false;
	}
</script>
</head>
<body>
	<header>
		<div class="navbar navbar-dark bg-dark shadow-sm">
			<div class=" text-left container">
				<a href="/home" class="navbar-brand d-flex align-items-center">
					<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20"
						fill="none" stroke="currentColor" stroke-linecap="round"
						stroke-linejoin="round" stroke-width="2" aria-hidden="true"
						class="me-2" viewBox="0 0 24 24">
						<path
							d="M23 19a2 2 0 0 1-2 2H3a2 2 0 0 1-2-2V8a2 2 0 0 1 2-2h4l2-3h6l2 3h4a2 2 0 0 1 2 2z" />
						<circle cx="12" cy="13" r="4" /></svg> <strong>상권현황제공 창업커뮤니티</strong>
				</a>
			</div>
			<div>
				<a id="login" href="/login/loginForm"> <strong>로그인</strong>
				</a> <a id="add" href="/user/add"> <strong>회원가입</strong>
				</a>
			</div>
			<div>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarHeader"
					aria-controls="navbarHeader" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
			</div>
		</div>
		<div class="collapse bg-dark" id="navbarHeader">
			<div class="container">
				<div class="row">
					<div class="col-sm-8 col-md-5 py-4">
						<h4 class="text-white">커뮤니티</h4>
						<!--                     <p class="text-muted">공지사항</p> -->
						<ul class="list-unstyled">
							<li><a href="/board/main" class="text-white">커뮤니티 메인화면</a></li>
							<li><a href="/board/notice" class="text-white">공지사항</a></li>
							<li><a href="/board/list" class="text-white">자유게시판</a></li>
							<li><a href="/board/ads" class="text-white">광고게시판</a></li>
						</ul>
					</div>
					<div class="col-sm-4 col-md-5 py-4">
						<h4 class="text-white">정보</h4>
						<ul class="list-unstyled">
							<li><a href="/board/notice" class="text-white">지역별
									현황(지도)</a></li>
							<li><a href="/board/notice" class="text-white">상권현황
									상세데이터</a></li>
							<li><a href="/board/notice" class="text-white">정부 지원사업
									정보</a></li>
						</ul>
					</div>
					<div class="col-sm-4 col-md-2 py-4">
						<h4 class="text-white">이용안내</h4>
						<ul class="list-unstyled">
							<li><a href="/home/dataSource" class="text-white">데이터 출처</a></li>
							<li><a href="/home/siteIntroduction" class="text-white">사이트소개</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</header>
	<main>
		<h3>게시판 글 입력 폼</h3>
		<form id="input_form" method="post" action="/board/save"
			onsubmit="return save();">
			<input type="hidden" name="pcode" value="${board.pcode}">
			<div>
				<select name="type">
				<option value="free">자유게시판</option>
				<option value="free">자유게시판</option>
				</select>
			</div>
			<div>
				<label for="title">제목</label> <input type="text" id="title"
					name="title">
			</div>
			<div>
				<label for="contents">내용</label>
				<textarea id="contents" name="contents" placeholder="글 입력..."></textarea>
			</div>
			<div>
				<button type="reset">취소</button>
				<button type="submit">저장</button>
			</div>
		</form>
		<nav>
			[<a href="/board/list">목록보기</a>] [<a href="/board/main">커뮤니티 메인화면</a>]
		</nav>
	</main>
	<footer class="text-muted py-5">
		<div class="container">
			<p class="float-end mb-1">
				<a href="#">Back to top</a>
			</p>
			<p class="mb-1">Album example is &copy; Bootstrap, but please
				download and customize it for yourself!</p>
			<p class="mb-0">
				New to Bootstrap? <a href="/">Visit the homepage</a> or read our <a
					href="../getting-started/introduction/">getting started guide</a>.
			</p>
		</div>
	</footer>
</body>
</html>