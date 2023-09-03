<script setup>

import { ref } from 'vue';
import DataService from '/src/services/DataService.js'

const props = defineProps({
    bookId: Number
})

const book = ref({
    id: Number,
    name: String,
    author: String
})

function getBook(id) {
    console.log(id);
    DataService.getOne(id).then(response => book.value = response.data);
}

// TODO:  Update book 
//            Make something to update the book data in this component when it is called

</script>

<template>

<div id="background-blackout">
  <div id="window">
    {{ book }}
    <a href="#" class="close">Close window</a>
  </div>
</div>

</template>

<style>

#background-blackout {
  background: rgba(102, 102, 102, 0.5);
  width: 100%;
  height: 100%;
  position: absolute;
  top: 0;
  left: 0;
  display: none;
}
#window {
  width: 50%;
  height: 50%;
  text-align: center;
  padding: 15px;
  border: 3px solid #0000cc;
  border-radius: 10px;
  color: #0000cc;
  position: absolute;
  top: 0;
  right: 0;
  bottom: 0;
  left: 0;
  margin: auto;
  background: #fff;
}
#background-blackout:target {display: block;}
.close {
  display: inline-block;
  border: 1px solid #0000cc;
  color: #0000cc;
  padding: 0 12px;
  margin: 10px;
  text-decoration: none;
  background: #f2f2f2;
  font-size: 14pt;
  cursor:pointer;
}
.close:hover {background: #e6e6ff;}

</style>