const express = require('express');
const app = express();
const PORT = 3000;

app.use(express.urlencoded({ extended: true }));
app.use(express.static('public'));

// Home page
app.get('/', (req, res) => {
  res.send('<h1>Welcome to My Site</h1><p><a href="/contact">Contact Us</a></p>');
});

// Handle form submission
app.post('/contact', (req, res) => {
  const { name, message } = req.body;
  res.send(`<h3>Thanks, ${name}!</h3><p>Your message: ${message}</p>`);
});

app.listen(PORT, () => {
  console.log(`Server running at http://localhost:${PORT}`);
});