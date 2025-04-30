const express = require('express');
const app = express();
const PORT = 3000;

app.use(express.urlencoded({ extended: true }));

// Home page
app.get('/', (req, res) => {
  res.send('<h1>Welcome to My Site</h1><p><a href="/contact">Contact Us</a></p>');
});

// Contact form
app.get('/contact', (req, res) => {
  res.send(`
    <h2>Contact Us</h2>
    <form action="/contact" method="POST">
      <label>Name: <input type="text" name="name" /></label><br/>
      <label>Message: <textarea name="message"></textarea></label><br/>
      <button type="submit">Send</button>
    </form>
  `);
}); 

// Handle form submission
app.post('/contact', (req, res) => {
  const { name, message } = req.body;
  res.send(`<h3>Thanks, ${name}!</h3><p>Your message: ${message}</p>`);
});

app.listen(PORT, () => {
  console.log(`Server running at http://localhost:${PORT}`);
});