document.addEventListener("DOMContentLoaded", function() {
    var menuItems = document.querySelectorAll('.sub-menu > a');
    
    menuItems.forEach(function(item) {
        item.addEventListener('click', function(e) {
            e.preventDefault();
            toggleSubMenu(this.parentNode);
        });
    });

    function toggleSubMenu(subMenu) {
        var isActive = subMenu.classList.contains('active');

        // Cerrar todos los submenús
        menuItems.forEach(function(item) {
            item.parentNode.classList.remove('active');
        });

        // Abrir o cerrar el submenú actual
        if (!isActive) {
            subMenu.classList.add('active');
        }
    }
});