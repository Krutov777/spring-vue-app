<template>
  <div class="electronic">
    <div>
      <div><strong>Название модели: </strong>{{ electronic.nameModel }}</div>
      <div><strong>Название компании: </strong>{{ electronic.nameCompany }}</div>
      <div><strong>Стоимость: </strong>{{ electronic.cost }}</div>
    </div>
    <div class="electronic_btns">
      <div v-if="profile.name">
        <my-button @click="$emit('remove', electronic)"
                   type="submit" class="btn btn-sm red">
          Удалить
        </my-button>
      </div>
    </div>
  </div>
</template>

<script>

export default {

  props: {
    electronic: {
      type: Object,
      required: true
    },

    profile: {
      type: Object,
      required: true
    }
  }
}
</script>

<style scoped>
.electronic {
  padding: 15px;
  border: 2px solid teal;
  margin: 15px;
  display: flex;
  align-items: center;
  justify-content: space-between;
}
</style>