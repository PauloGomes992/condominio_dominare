document.addEventListener("DOMContentLoaded", function () {
    const toggler = document.querySelector(".navbar-toggler");
    const icon = toggler.querySelector("i");

    toggler.addEventListener("click", function () {
        const isExpanded = toggler.getAttribute("aria-expanded") === "true";

        
        if (isExpanded) {
            icon.classList.remove("bi-chevron-right");
            icon.classList.add("bi-chevron-left");
        } else {
            icon.classList.remove("bi-chevron-left");
            icon.classList.add("bi-chevron-right");
        }
    });
});