/*function showDeleteConfirmation() {
  let text = "Are you sure to delete this record?\nPress OK or Cancel.";
  if (confirm(text) == true) {
	th:href="@{/deleteCustomer/{id}(id=${customer.customerId})}"
  } else {
  }
}*/

/*return navbar for webpages*/
/*
function showNavBar(){
  $("#nav-placeholder").load("nav.html");
}
*/

/*
 * switch boostrap theme using js
 * credits to https://blog.shhdharmen.me/toggle-light-and-dark-themes-in-bootstrap
 */
const LOCAL_STORAGE_THEME = "local_theme";
const LOCAL_META_DATA = JSON.parse(localStorage.getItem(LOCAL_STORAGE_THEME));
const DARK_THEME_URL = "https://bootswatch.com/5/darkly/bootstrap.min.css";
const DARK_STYLE_LINK = document.getElementById("dark-theme-style");
const THEME_TOGGLER = document.getElementById("theme-toggler");

let darkThemed = LOCAL_META_DATA && LOCAL_META_DATA.darkThemed;
// check if user has already selected dark theme earlier
if (darkThemed) {
	enableDarkTheme();
} else {
	disableDarkTheme();
}

function toggleTheme() {
	darkThemed  = !darkThemed;
	if (darkThemed ) {
		enableDarkTheme();
	} else {
		disableDarkTheme();
	}
	const META = { darkThemed  };
	localStorage.setItem(LOCAL_STORAGE_THEME, JSON.stringify(META));
}

function enableDarkTheme() {
	DARK_STYLE_LINK.setAttribute("href", DARK_THEME_URL);
	THEME_TOGGLER.innerHTML = "Light Mode";
}

function disableDarkTheme() {
	DARK_STYLE_LINK.setAttribute("href", "");
	THEME_TOGGLER.innerHTML = "Dark Mode";
}