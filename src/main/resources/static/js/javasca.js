document.addEventListener("DOMContentLoaded", function () {
    var menuItems = document.querySelectorAll('.sub-menu > a');

    menuItems.forEach(function (item) {
        item.addEventListener('click', function (e) {
            var sectionId = item.id;

            if (sectionId === 'usuarios') {
                document.querySelector('.menup').classList.remove('hidden');
                document.querySelector('.menup2').classList.add('hidden');
            } else if (sectionId === 'Reservas') {
                document.querySelector('.menup').classList.add('hidden');
                document.querySelector('.menup2').classList.remove('hidden');
            } else {
                // Handle other sections if necessary
            }
        });
    });
});
