const express = require('express');
const router = express.Router();

router.get("/contact",(res, req) => {
    res.render("contact");
});