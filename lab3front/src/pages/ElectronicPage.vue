<template>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
  <div>
    <my-animation>
      <template v-slot:first>Вечная память Billy Herrington, актеру эстрады, певцу и просто хорошему человеку.
      </template>
      <template v-slot:second>Магазин электроники</template>
      <template v-slot:third>Давным-давно, в далёкой-далёкой галактике…</template>
    </my-animation>
    <div v-if="profile.name">
      <my-button
          @click="showDialog"
          class="btn btn-lg green"
      >
        Добавить электронику
      </my-button>
    </div>
    <div v-if="profile.name">
      <my-dialog v-model:show="dialogVisible">
        <electronic-form
            @click="showDialog"
            @create="createElectronic"
        >
          Добавить
        </electronic-form>
      </my-dialog>
    </div>
    <div>
      <electronic-list
          :profile="profile"
          :electronics="electronics"
          @remove="removeElectronic"
      />
    </div>
  </div>
</template>

<script>
import ElectronicList from "@/components/ElectronicList";
import ElectronicForm from "@/components/ElectronicForm";

import axios from 'axios';

export default {
  components: {
    ElectronicList, ElectronicForm
  },
  data() {
    return {
      electronics: [],
      profile: Object,
      dialogVisible: false,
    }
  },
  methods: {

    createElectronic(electronic) {
      this.electronics.push(electronic);
      this.dialogVisible = false;
      this.postElectronics(electronic);
    },


    removeElectronic(electronic) {
      this.electronics = this.electronics.filter(el => el.id !== electronic.id);
      this.deleteElectronics(electronic);
    },

    showDialog() {
      this.dialogVisible = true;
    },

    async fetchElectronics() {
      try {
        const response = await axios.get('http://localhost:8080/electronics');
        this.electronics = response.data;
      } catch (e) {
        alert('Ошибка')
      }
    },
    async postElectronics(electronic) {
      try {
        const response = await axios.post('http://localhost:8080/electronics', electronic);
      } catch (e) {
        alert('Ошибка')
      }
    },
    async deleteElectronics(electronic) {
      try {
        let idElectronic = electronic.id;
        const response = await axios.delete('http://localhost:8080/electronics/'+idElectronic, electronic);
      } catch (e) {
        alert('Ошибка')
      }
    }
  },
  mounted() {
    this.fetchElectronics();
  }
}
</script>

<style>
body {
  background: url(https://img.wallpapersafari.com/desktop/1920/1080/36/60/KblsVE.jpg)
}

* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

.app {
  padding: 20px;
}

</style>
