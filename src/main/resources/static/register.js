function registerAutoPart(code, name, price) {
  const apiUrl = 'http://localhost:8080/autoparts'; // Replace with your actual API endpoint

  // Data for the new auto part
  const autoPartData = {
    code: code.value,
    name: name.value,
    price: price.value
  };

  // Configure the request
  const requestOptions = {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(autoPartData)
  };

  // Make the POST request
  fetch(apiUrl, requestOptions)
    .then(response => {
      if (!response.ok) {
        throw new Error(`HTTP error! Status: ${response.status}`);
      }
      return response.json();
    })
    .then(data => {
      console.log('New auto part created:', data);
      // Clear input fields (assuming they have a value property)
      code.value = "";
      name.value = "";
      price.value = "";
    })
    .catch(error => {
      console.error('Error:', error);
      // Handle error here (e.g., display an error message)
    });
}
