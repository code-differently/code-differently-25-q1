const express = require('express');
const path = require('path');
const app = express();
const PORT = 4001;

app.use(express.static('public'));
app.use(express.urlencoded({ extended: true }));

// Set EJS as the template engine
app.set('view engine', 'ejs');
app.set('views', path.join(__dirname, 'views')); // A new "views" folder

app.post('/submit', (req, res) => {
  const { name, email, message } = req.body;
  res.render('sentinfo', { name, email, message });
});

app.listen(PORT, () => {
  console.log(`Server running at http://localhost:${PORT}`);
});
