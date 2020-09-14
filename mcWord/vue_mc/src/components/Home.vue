<template>
    <div>
        <NavMenu></NavMenu>
        <router-view></router-view>
    </div>
</template>

<script>
    import NavMenu from '../components/article/NavMenu';

    export default {
        name: 'Home',
        components: {NavMenu},

    }
</script>

<style scoped>

</style>

