var form = document.getElementById("addForm");
var itemList = document.getElementById("items");

// Form submit event
form.addEventListener("submit", addItem);

// Delete event
itemList.addEventListener("click", removeItem);

// Add item
function addItem(e) {
  e.preventDefault();

  // Get input value
  var newItem = document.getElementById("item").value;

  // Create new li element
  var li = document.createElement("li");

  // Add text node with input value
  li.appendChild(document.createTextNode(newItem));

  // Create del button element
  var deleteBtn = document.createElement("button");

  // Add classes to del button
  deleteBtn.className="delete";

  // Append text node
  deleteBtn.appendChild(document.createTextNode("X"));

  // Append button to li
  li.appendChild(deleteBtn);

  // Append li to list
  itemList.appendChild(li);
}

// Remove item
function removeItem(e) {
  if (e.target.classList.contains("delete")) {
    if (confirm("Are You Sure, you want to delete this item ?")) {
      var li = e.target.parentElement;
      itemList.removeChild(li);
      alert('Item deleted successfully');
    }
  }
}
