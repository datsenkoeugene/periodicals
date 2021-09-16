export const changeActiveLink = selector => {
    const paginationLinks = document.querySelectorAll(selector);
    if (paginationLinks) {
        paginationLinks.forEach(link => link.classList.remove('active'));
        paginationLinks[document.documentElement.getAttribute('page') - 1]?.classList.add('active');
    }
}