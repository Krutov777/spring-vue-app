<template>
  <div class="navbar">
    <div @click="$router.push('/')">Electronics store(training project)</div>
    <div class="navbar_btns">
      <my-button style="margin-left: 20px" @click="$router.push('/electronics')">Электроника</my-button>
      <my-button style="margin-left: 20px" @click="$router.push('/about')">О приложении</my-button>
    </div>
  </div>
</template>

<script>
export default {
methods: {
  logout() {
    window.location.href = "http://localhost:8080/logout";
  }
}
}
</script>

<style scoped>

.navbar {
  height: 50px;

  box-shadow: 2px 2px 4px gray;
  display: flex;
  align-items: center;
  padding: 0 15px;
}
.navbar_btns {
  margin-left: auto;
  margin-top: -10px;
}

</style>