document.addEventListener("DOMContentLoaded", function () {

  // Function to register a new auto part
  function registerAutoPart() {
    const formPartCode = document.getElementById("code").value;
    const formPartName = document.getElementById("name").value;
    const formPrice = document.getElementById("price").value;

    const newAutoPart = {
      code: formPartCode,
      name: formPartName,
      price: formPrice,
    };

    const apiUrl = "http://localhost:8080/autoparts"; // Replace with actual API endpoint

    // Configure the request
    const requestOptions = {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(newAutoPart)
    };

    // Make the POST request
    fetch(apiUrl, requestOptions)
      .then(response => {
        if (!response.ok) {
          throw new Error(`HTTP error! Status: ${response.status}`);
        }
        return response.json();
      })
      .then(autoPartFromAPI => {
        console.log('New auto part created:', autoPartFromAPI);
        cleanFormFields();
        alert("¡Autoparte registrada con éxito!");
      })
      .catch(error => {
        console.error('Error:', error);
        // Handle error here
      });
  }

  // Function to clean form fields
  function cleanFormFields() {
    document.getElementById("code").value = "";
    document.getElementById("name").value = "";
    document.getElementById("price").value = "";
  }

  // Function to save the auto part (combines logic)
  function saveAutoPart() {
    registerAutoPart(); // Call the existing function to register
  }

  // Add event listener to the register button (modified for "save")
  const registerButton = document.getElementById("registerButton");
  if (registerButton) {
    registerButton.addEventListener("click", saveAutoPart);
  } else {
    console.error("No se encontró el botón de registro.");
  }

});

  