<template>
  <div class="container"><div class="row">
    <div class="col-xs-12 marquee"><span><slot name="first"></slot></span></div>
    <div class="col-xs-12 marquee"><h1><slot name="second"></slot></h1></div>
    <div class="col-xs-12 marquee"><p class="lead"><slot name="third"></slot></p></div>
  </div></div>
</template>

<script>
export default {
  name: 'my-animation'
}
</script>

<style scoped>

@keyframes scroll {
  0% {
    transform: translate(0, 0);
  }
  100% {
    transform: translate(-100%, 0)
  }
}

.marquee {
  max-width: 100%;
  white-space: nowrap;
  overflow: hidden;
}

.marquee * {
  display: inline-block;
  padding-left: 100%;
  -webkit-animation: scroll 21s infinite linear;
  animation: scroll 21s infinite linear;
}
.marquee *:hover {
  -webkit-animation-play-state: paused;
  animation-play-state: paused;
}
</style>