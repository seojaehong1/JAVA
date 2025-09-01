<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_partials/header.jspf" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/jsp/_partials/header.jspf" %>
<%@ include file="/WEB-INF/jsp/_partials/footer.jspf" %>
<main class="container mx-auto px-5">
  <!-- 히어로 -->
  <section class="py-16">
    <h1 class="text-4xl md:text-5xl font-extrabold tracking-tight mb-4 dark:text-white">
      Hello, I'm <span class="text-indigo-600">서재홍</span> 👋
    </h1>
    <p class="text-zinc-600 dark:text-zinc-300 text-lg leading-relaxed max-w-2xl">
      백엔드/시스템에 강한 개발자. 여기엔 제가 만든 프로젝트와 기술 블로그를 정리합니다.
    </p>

    <!-- 빠른 CTA -->
    <div class="mt-6 flex gap-3">
      <a href="#projects" class="px-4 py-2 rounded-xl bg-indigo-600 text-white hover:bg-indigo-700">Projects 보기</a>
      <a href="#posts" class="px-4 py-2 rounded-xl border hover:bg-zinc-50 dark:hover:bg-zinc-800 dark:text-zinc-200">블로그 글</a>
    </div>
  </section>

  <!-- 프로젝트/포스트 목록 -->
  <section id="projects" class="py-6">
    <div class="flex items-end justify-between mb-4">
      <h2 class="text-2xl font-bold dark:text-white">Latest Projects</h2>
      <!-- 카테고리/태그 필터 자리 -->
      <form method="get" action="">
        <select name="tag" class="border rounded-xl px-3 py-2 text-sm dark:bg-zinc-900 dark:text-zinc-200">
          <option value="">All</option>
          <option>Java</option>
          <option>SQL</option>
          <option>Docker</option>
        </select>
        <button class="ml-2 px-3 py-2 rounded-xl border text-sm dark:text-zinc-200">Filter</button>
      </form>
    </div>

    <!-- posts: request.setAttribute("posts", List<PostDTO>) 가정 -->
    <c:choose>
      <c:when test="${not empty posts}">
        <div class="grid md:grid-cols-3 gap-6">
          <c:forEach var="p" items="${posts}">
            <article class="rounded-2xl border hover:shadow-md transition-all bg-white dark:bg-zinc-900 dark:border-zinc-800">
              <a class="block p-5" href="<c:url value='/post?id=${p.id}'/>">
                <h3 class="text-lg font-semibold mb-2 dark:text-white">${p.title}</h3>
                <p class="text-sm text-zinc-600 dark:text-zinc-400 line-clamp-3">${p.summary}</p>
                <div class="mt-4 text-xs text-zinc-500 dark:text-zinc-400 flex items-center justify-between">
                  <span>${p.date}</span>
                  <span class="inline-flex gap-1">
                    <c:forEach var="t" items="${p.tags}">
                      <span class="px-2 py-0.5 rounded-full border text-[11px]">${t}</span>
                    </c:forEach>
                  </span>
                </div>
              </a>
            </article>
          </c:forEach>
        </div>
      </c:when>
      <c:otherwise>
        <!-- 더미 카드 (데이터 없을 때 가이드) -->
        <div class="grid md:grid-cols-3 gap-6">
          <div class="rounded-2xl border p-5 dark:bg-zinc-900 dark:border-zinc-800">
            <h3 class="text-lg font-semibold mb-2 dark:text-white">첫 포스트를 등록해보세요</h3>
            <p class="text-sm text-zinc-600 dark:text-zinc-400">컨트롤러에서 posts 리스트를 전달하면 여기에 카드가 나옵니다.</p>
          </div>
        </div>
      </c:otherwise>
    </c:choose>
  </section>

  <!-- About -->
  <section id="about" class="py-16">
    <h2 class="text-2xl font-bold mb-4 dark:text-white">About</h2>
    <p class="text-zinc-700 dark:text-zinc-300 leading-relaxed">
      간단한 자기소개 영역. 이 문단은 자유롭게 수정하세요.
    </p>
  </section>

  <!-- Contact -->
  <section id="contact" class="py-16">
    <h2 class="text-2xl font-bold mb-4 dark:text-white">Contact</h2>
    <ul class="space-y-2 text-zinc-700 dark:text-zinc-300">
      <li>📧 email wtme3@naver.com</li>
      <li>💼 /in/your-handle</li>
      <li>🐙 github.com/your-handle</li>
    </ul>
  </section>
</main>

<%@ include file="/WEB-INF/jsp/_partials/footer.jspf" %>
