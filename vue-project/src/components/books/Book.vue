<template>
    <p>{{ book.name + ' ' + book.author }}</p>
</template>

<script setup>
import { onMounted, ref } from "vue";
import { useRoute } from "vue-router";

const book = ref({
    id: Number,
    name: String,
    author: String
});

async function getBookDetails(id) {
    try {
        const bookDetails = await fetch('http://localhost:8080/test/' + id);
        book.value = await bookDetails.json();
    } catch (error) {
        console.error(error);
    }
};

onMounted(() => getBookDetails(useRoute().params.id));

</script>

<style></style>