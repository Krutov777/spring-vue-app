<template>
  <div>
    <form @submit.prevent>
      <h4>Добаление электроники</h4>

      <my-input v-model="electronic.nameModel"
                type="text" placeholder="Название модели" />
      <my-input v-model="electronic.nameCompany"
                type="text" placeholder="Название компании"/>
      <my-input v-model="electronic.cost" type="number"
                placeholder="Стоимость"/>
      <my-button
          type="submit"
          class="btn btn-lg green"
          style="align-self: flex-end"
          v-on:click="createElectronic(); editElectronic();"
      >
        <slot></slot>
      </my-button>
      <!--      <button class="btn">Добавить</button>-->
    </form>
  </div>
</template>

<script>

export default {

  data() {
    return {
      electronic: {
        nameModel: '',
        nameCompany: '',
        cost: null
      }
    }
  },
  methods: {
    createElectronic() {
      this.electronic.id = Date.now();
      this.$emit('create', this.electronic)
      this.electronic = {
        nameModel: '',
        nameCompany: '',
        cost: null
      }
    },
    /*editElectronic(electronic) {
      this.electronic.id = electronic;
      this.$emit('edit', this.electronic)
      this.electronic = {
        nameModel: this.electronic.nameModel,
        nameCompany: this.electronic.nameCompany,
        cost: this.electronic.cost
      }
    }*/
  }
}
</script>

<style scoped>
form {
  display: flex;
  flex-direction: column;
}

</style>