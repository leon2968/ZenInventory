function showDeleteConfirmation() {
  let text = "Are you sure to delete this record?\nPress OK or Cancel.";
  if (confirm(text) == true) {
    th:href="@{/deleteCustomer/{id}(id=${customer.customerId})}"
  } else {
  }
}