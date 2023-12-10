<template>
  <HeaderPage></HeaderPage>
  <SideBar></SideBar>
</template>

<script>
import HeaderPage from './components/HeaderPage.vue' ;
import SideBar    from './components/SideBar.vue'    ;

export default {
  name: 'App',

  components: { 
    HeaderPage,
    SideBar,
  }
}

</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>