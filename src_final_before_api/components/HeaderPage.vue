<template>
  <header>
      <h1>Paint</h1>
  </header>
</template>

<script>
export default {
  name: 'HeaderPage'
}
</script>

<style scoped>
  @import url('https://fonts.googleapis.com/css2?family=Grand+Hotel&display=swap');

  header {
      background-image: linear-gradient(90deg, rgba(13, 182, 255, 0.57), rgba(0, 3, 190, 0.733), rgba(126, 0, 205, 0.651)) ;
      top             : 0             ;
      width           : 100%          ;
      height          : 10%           ;
      display         : flex          ;
      justify-content : center        ;
      align-items     : center        ;
      position        : fixed         ; 
      font-family     : 'Grand Hotel' ;
      padding         : 20px          ;
      color           : #fff        ;
  }
</style>