const body = document.querySelector("body");
const sidebar = document.querySelector(".sidebar");
const submenuItems = document.querySelectorAll(".submenu_item");
const sidebarOpen = document.querySelector("#sidebarOpen");
const sidebarClose = document.querySelector(".collapse_sidebar");
const sidebarExpand = document.querySelector(".expand_sidebar");
sidebarOpen.addEventListener("click", () => sidebar.classList.toggle("close"));

sidebarClose.addEventListener("click", () => {
  sidebar.classList.add("close", "hoverable");
});
sidebarExpand.addEventListener("click", () => {
  sidebar.classList.remove("close", "hoverable");
});

sidebar.addEventListener("mouseenter", () => {
  if (sidebar.classList.contains("hoverable")) {
    sidebar.classList.remove("close");
  }
});
sidebar.addEventListener("mouseleave", () => {
  if (sidebar.classList.contains("hoverable")) {
    sidebar.classList.add("close");
  }
});

submenuItems.forEach((item, index) => {
  item.addEventListener("click", () => {
    item.classList.toggle("show_submenu");
    submenuItems.forEach((item2, index2) => {
      if (index !== index2) {
        item2.classList.remove("show_submenu");
      }
    });
  });
});

if (window.innerWidth < 768) {
  sidebar.classList.add("close");
} else {
  sidebar.classList.remove("close");
}


/* Modals */

/* Keep both modals open (JQuery) */
function openSecondModal(id) {
  $(document).ready(function () {
    $(id).modal('show')
  });
}

/* Modal Class */
$(document).ready(function() {
  // Añadir nueva fila al hacer clic en "Nuevo"
  $('#addRow').click(function() {
    if (areInputsComplete()) {
      addNewRow();
    } else {
      alert("Por favor, complete todos los campos antes de añadir una nueva fila.");
    }
  });

  // Añadir nueva fila al presionar "Enter"
  $('#classTableBody').on('keypress', 'input', function(e) {
    if (e.which === 13) {
      e.preventDefault(); // Evitar que se envíe el formulario
      if (areInputsComplete()) {
        addNewRow();
      } else {
        alert("Por favor, complete todos los campos antes de añadir una nueva fila.");
      }
    }
  });

  // Verificar si los inputs de la última fila están completos
  function areInputsComplete() {
    return $('#classTableBody tr:last input').toArray().every(input => $(input).val());
  }

  // Añadir nueva fila
  function addNewRow() {
    // Desactivar los inputs de la fila anterior
    $('#classTableBody tr:last input').prop('readonly', true);

    // Crear nueva fila con inputs vacíos
    const newRow = `
            <tr>
                <td><input type="number" class="form-control" placeholder="01" required></td>
                <td><input type="text" class="form-control" placeholder="Descripción" required></td>
                <td class="narrow-column">
                    <i class="bx bx-edit-alt bx-md edit-btn" style="cursor:pointer;"></i>
                </td>
                <td class="narrow-column">
                    <i class="bx bx-trash bx-md delete-btn" style="cursor:pointer;"></i>
                </td>
            </tr>`;

    $('#classTableBody').append(newRow);
  }

  // Editar fila
  $('#classTableBody').on('click', '.edit-btn', function() {
    const row = $(this).closest('tr');
    const inputs = row.find('input');

    inputs.prop('readonly', !inputs.prop('readonly'));
  });

  // Eliminar fila
  $('#classTableBody').on('click', '.delete-btn', function() {
    $(this).closest('tr').remove();
  });
});
