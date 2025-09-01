<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_partials/header.jspf" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<main class="container mx-auto px-5 py-12">
  <!-- 컨트롤러에서 request.setAttribute("post", PostDTO) 가정 -->
  <article class="prose prose-zinc max-w-none dark:prose-invert">
    <h1>${post.title}</h1>
    <p class="text-sm text-zinc-500 dark:text-zinc-400">
      ${post.date} ·
      <c:forEach var="t" items="${post.tags}">
        <span class="px-2 py-0.5 rounded-full border text-[11px]">${t}</span>
      </c:forEach>
    </p>
    <hr/>
    <!-- 실제 본문 HTML을 서버에서 safe-render 하거나 markdown -> html 변환 후 주입 -->
    <div>${post.contentHtml}</div>
  </article>

  <!-- 이전/다음 네비게이션 자리 -->
  <div class="mt-10 flex items-center justify-between">
    <c:if test="${not empty prev}">
      <a href="<c:url value='/post?id=${prev.id}'/>" class="text-sm hover:underline">← ${prev.title}</a>
    </c:if>
    <c:if test="${not empty next}">
      <a href="<c:url value='/post?id=${next.id}'/>" class="text-sm hover:underline">${next.title} →</a>
    </c:if>
  </div>
</main>

<%@ include file="/WEB-INF/jsp/_partials/footer.jspf" %>
