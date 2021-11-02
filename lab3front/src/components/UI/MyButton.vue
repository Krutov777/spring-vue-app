<template>
  <button class="btn">
    <slot>

    </slot>
  </button>
</template>

<script>
export default {
  name: 'my-button'
}
</script>

<style scoped>

.btn {
  margin-top: 15px;
  padding: 10px 15px;
  background: none;
  color: teal;
  border: 1px solid teal;
}

.btn{
  border-radius: 0;
  text-transform: uppercase;
  position: relative;
  overflow: hidden;
  z-index: 1;
  transition: all 0.4s ease 0s;
}
.btn:before{
  content: "";
  width: 210%;
  height: 210%;
  position: absolute;
  top: -120px;
  left: 30px;
  transform: skew(67deg);
  z-index: -1;
  transition: all 0.4s ease 0s;
}
.btn:hover:before{
  top: -20px;
  left: -52px;
}
.btn.red{
  border: 1px solid #ff3939;
  color: #ff3939;
}
.btn.red:hover:before{
  background: #ff3939;
}
.btn.blue{
  border: 1px solid #3fb7c8;
  color: #3fb7c8;
}
.btn.blue:hover:before{
  background: #3fb7c8;
}
.btn.orange{
  border: 1px solid #f88030;
  color: #f88030;
}
.btn.orange:hover:before{
  background: #f88030;
}
.btn.green{
  border: 1px solid #35c568;
  color: #35c568;
}
.btn.green:hover:before{
  background: #35c568;
}
.btn.red:hover,
.btn.blue:hover,
.btn.orange:hover,
.btn.green:hover{
  color: #fff;
}
@media screen and (max-width: 767px){
  .btn{ margin-bottom: 15px; }
}
.pad-15{
  padding: 15px 0;
}
</style>