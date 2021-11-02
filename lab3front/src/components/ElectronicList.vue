<template>
  <div v-if="electronics.length > 0">
    <h3>Список электроники</h3>
    <electronic-item
        v-for="electronic in electronics"
        :electronic="electronic"
        :key="electronic.id"
        @remove="$emit('remove', electronic)"
    />
  </div>
  <h2 v-else style="color: red">
    Список электроники пуст
  </h2>
</template>

<script>
import ElectronicItem from "@/components/ElectronicItem";

export default {
  components: {ElectronicItem},
  props: {
    electronics: {
      type: Array,
      required: true
    }
  }

}
</script>

<style scoped>

</style>