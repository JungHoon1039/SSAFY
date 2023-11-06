<template>
    <div>
        <h2>UserView</h2>
        <p>{{ $route.params.id }}</p>
        <p>{{ userId }}</p>
        <p>{{ userId2 }}</p>
        <p>{{ userId3 }}</p>
        <hr>
        <button @click="goHome">홈으로</button>
    </div>
</template>

<script setup>
import { onBeforeRouteLeave, onBeforeRouteUpdate, useRoute, useRouter } from 'vue-router';
import { ref, watch } from 'vue';
const route = useRoute();
const userId = ref(route.params.id);
const userId2 =ref(route.params.id)
const userId3 =ref('');
const router = useRouter()
const goHome = function() {
    // router.push('/');
    // router.push({name: "about"});
    router.replace({name:'home'});
};
watch(()=>route.params.id, (newId)=>userId2.value = newId);
onBeforeRouteLeave(() => {
    const answer = confirm("정말로 떠나실 건가요?");
    if (!answer) return false
})
onBeforeRouteUpdate((to)=>{
    userId3.value = to.params.id
})

</script>

<style scoped>

</style>