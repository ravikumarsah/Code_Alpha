function convertToFahrenheit() {
   const fahrenheitInput = document.getElementById("fahrenheit");
   const celsiusResult = document.getElementById("celsiusResult");
   const fahrenheit = parseFloat(fahrenheitInput.value);
   const celsius = (fahrenheit - 32) * 5/9;
   celsiusResult.textContent = `Celsius: ${celsius.toFixed(2)}°C`;
}

function convertToCelsius() {
   const celsiusInput = document.getElementById("celsius");
   const fahrenheitResult = document.getElementById("fahrenheitResult");
   const celsius = parseFloat(celsiusInput.value);
   const fahrenheit = (celsius * 9/5) + 32;
   fahrenheitResult.textContent = `Fahrenheit: ${fahrenheit.toFixed(2)}°F`;
}
