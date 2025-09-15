<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ToDo List</title>
<style>
  .completed { text-decoration: line-through; color: gray; }
  /* 🔹 실패(X) 오버레이 - 최소 스타일 */
  .failed-x { position: relative; display: inline-block; }
  .failed-x::before, .failed-x::after {
    content: ""; position: absolute; left: -2px; right: -2px; top: 50%;
    border-top: 2px solid #e53935;
  }
  .failed-x::before { transform: rotate(45deg); }
  .failed-x::after  { transform: rotate(-45deg); }
</style>

</head>
<body>
<h2>할 일 목록</h2>
<a href="add">할 일 추가</a>
<ul>
	<c:forEach var="todo" items="${todos }">
<li>
  <a href="toggle/${todo.id}">
    <!-- 🔹 title 클래스만 추가 -->
    <span class="title ${todo.completed ? 'completed' : ''}">
      ${todo.title}
    </span>
    [${todo.completed ? '완료됨' : '미완료'}]
  </a>

  <a href="delete/${todo.id}">[삭제]</a>

  <!-- 🔹 타이머 버튼 추가 -->
  <button type="button" class="timer-btn" data-id="${todo.id}">⏱ 타이머</button>
</li>
	</c:forEach>
</ul>
<script>
document.addEventListener('click', function(e) {
  if (!e.target.classList.contains('timer-btn')) return;

  const li = e.target.closest('li');
  const titleEl = li.querySelector('.title');
  if (!titleEl) return;

  // 간단 입력: 10/20/30 중 선택 (기본 30)
  const sec = parseInt(prompt('타이머(초): 10 / 20 / 30', '30'), 10) || 30;

  // 이미 완료면 타이머 불필요
  if (titleEl.classList.contains('completed')) return;

  setTimeout(function() {
    // 아직도 완료 아니면 실패 표시
    if (!titleEl.classList.contains('completed')) {
      titleEl.classList.add('failed-x');
    }
  }, sec * 1000);
});
</script>

</body>
</html>