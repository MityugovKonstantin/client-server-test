<script setup>
import { onMounted } from "vue";

onMounted(() => console.log('Main'))
</script>

<template>
    <h1>Welcome to DBA (Digital Book Accounting)</h1>
    <router-link to="/books">Go to books</router-link>
    <br/>
    <router-link to="/peoples">Go to people</router-link>
</template>

<style>

</style>