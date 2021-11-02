<template>
  <div class="dialog" v-if="show" @click.stop="hideDialog">
    <div @click.stop class="dialog_content">
      <slot></slot>
    </div>
  </div>
</template>

<script>
export default {
  name: 'my-dialog',
  props: {
    show: {
      type: Boolean,
      default: false
    }
  },
  methods: {
    hideDialog() {
      this.$emit('update:show', false)
    }
  }
}
//https://img.wallpapersafari.com/desktop/1920/1080/36/60/KblsVE.jpg
</script>

<style scoped>
body{background:url(https://www.wowperucken.de/media/catalog/product/cache/1/small_image/300x400/9df78eab33525d08d6e5fb8d27136e95/s/o/solw462-01.jpg)}

.dialog {
  top: 0;
  bottom: 0;
  right: 0;
  left: 0;
  background: rgba(0,0,0, 0.5);
  position: fixed;
  display: flex;
}

.dialog_content {
  margin: auto;
  background: url(https://club-source.ru/files/avatars/1625608802.jpg);
  border-radius: 12px;
  min-height: 50px;
  min-width: 300px;
  padding: 20px;
}

</style>