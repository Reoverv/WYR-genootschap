<script lang="ts">
    import "./app.css"

    import CardList from "./lib/Cards/CardList.svelte";
    import Searchbar from "./lib/Searchbar.svelte";
    import Title from "./lib/Title.svelte";
    import Nav from "./lib/Navigation/Nav.svelte";
    import {onMount} from "svelte";

    let blur = true

    let userToken = ""

    onMount(() => {
        userToken = localStorage.getItem("UserToken")

    })


    function checkToken(userToken) {
        let regex = /^.*\..*(\d([A-Za-z]+\d)+).*$/gm
        return !(userToken.length > 50 && userToken !== null && regex.test(userToken));

    }

    function updateToken() {
        userToken = document.getElementById("tokenInput").value
        localStorage.setItem("UserToken", userToken)
        console.log(userToken.length)
        blur = checkToken(userToken)
        document.getElementById("tokenInput").value = ""
        document.getElementById("tokenInput").placeholder = "Incorrecte token"
    }

</script>

<div class="bg-neutral-900 h-screen transition-all">
    <div class={blur ? "flex " : "flex"}>
        <div class="flex flex-col">
            <Title/>
            <Nav/>
        </div>
        <div class="flex flex-col">
            <Searchbar/>
            <CardList/>
        </div>
    </div>
    {#if !blur}
        <div class="place-items-center absolute top-1/2 left-1/2 transform -translate-x-1/2 -translate-y-1/2">
            <div class="bg-neutral-900 text-white shadow-sharp border-2 border-opacity-50 border-white flex-col h-full w-96 flex place-items-center rounded-2xl">
                <h2 class="p-5 pb-2 font-bold text-xl">Wat is jouw discord token?</h2>
                <h5 class="text-sm text-gray-300 text-center">Token wordt alleen lokaal opgeslagen</h5>
                <h5 class="text-sm text-gray-300 text-center">ik kan de token niet zien</h5>
                <input id="tokenInput" class="text-xl m-5 w-10/12 p-2 bg-neutral-800 rounded-lg" placeholder="Token">
                <button class="bg-red-400 mb-5 p-2 px-7 rounded-lg hover:scale-105 active:scale-100 transition-all transform-gpu duration-100"
                        on:click={updateToken}>voeg token toe
                </button>
            </div>
        </div>
    {/if}
</div>


<style lang="postcss"></style>