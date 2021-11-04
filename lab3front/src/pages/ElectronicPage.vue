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
      <div><strong>Name: </strong>{{ profile.name }}</div>
    </div>
    <div v-else>
      <div><strong>Name: </strong>Не авторизован</div>
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
    loginUser() {
      this.loginGoogle();
    },

    login() {
      window.location.href = "http://localhost:8080/sessions/Google/callback";
    },

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

    async loginGoogle() {
      try {
        axios.defaults.withCredentials = true
        const response = await axios.get("http://localhost:8080/electronics/sessions/me", {withCredentials: true});
        this.profile = response.data;
      } catch (e) {
        alert('Error')
      }
    },

    async getProfile() {
      try {
        axios.defaults.withCredentials = true
        const response = await axios.get("http://localhost:8080/electronics/profile", {withCredentials: true});
        this.profile = response.data;
      } catch (e) {
        alert('error')
      }
    },

    async fetchElectronics() {
      try {
        axios.defaults.withCredentials = true;
        const responseElectronic = await axios.get("http://localhost:8080/electronics", {withCredentials: true});
        this.electronics = responseElectronic.data;
      } catch (e) {
        alert(e.message)
      }
    },

    async postElectronics(electronic) {
      try {
        axios.defaults.withCredentials = true;
        await axios.post('http://localhost:8080/electronics/user/' + this.profile.id, electronic, {withCredentials: true});
        await this.fetchElectronics();
      } catch (e) {
        alert(e.message)
      }
    },

    async deleteElectronics(electronic) {
      try {
        axios.defaults.withCredentials = true;
        let idElectronic = electronic.id;
        const response = await axios.delete('http://localhost:8080/electronics/' + idElectronic, {withCredentials: true});
      } catch (e) {
        alert('Ошибка')
      }
    },

  },

  mounted() {
    this.getProfile();
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
