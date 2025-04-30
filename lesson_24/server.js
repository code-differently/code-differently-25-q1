const express = require('express');
const morgan = require ("morgan");
const path = require ("path");
var debug = require ('debug')('myapp:server');

const app = express();

app.use(morgan("dev"));
app.use(express.static(path.join(__dirname, "public")));
app.use(express.urlencoded({ extended: true}))

const PORT = process.env.PORT || 3000;

const contactRouter = require('./route/contact')

app.use('/contact', contactRouter)

app.listen(PORT, () => {
    debug(`Server listening on http://localhost:${PORT}`);
});
