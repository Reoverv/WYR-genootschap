<script>

    import {onMount} from "svelte";

    let seeTokenToggle = false

    export let blur



    function checkToken() {
        let regex = /^.*\..*(\d([A-Za-z]+\d)+).*$/gm
        let token = localStorage.getItem("DiscordToken")
        if (token === null){
            return true
        }

        blur = !(token.length > 50 && token !== null && regex.test(token))

        return !(token.length > 50 && token !== null && regex.test(token));

    }

    function seeToken() {
        seeTokenToggle = !seeTokenToggle
        if (seeTokenToggle) {
            document.getElementById("tokenInput").type = "text"
            return
        }
        document.getElementById("tokenInput").type = "password"
    }

    function updateToken() {
        let userToken = document.getElementById("tokenInput").value
        localStorage.setItem("DiscordToken", userToken)

        blur = checkToken()

        document.getElementById("tokenInput").value = ""
        document.getElementById("tokenInput").placeholder = "Incorrecte token"
    }


</script>

<div class="place-items-center absolute top-1/2 left-1/2 transform -translate-x-1/2 -translate-y-1/2">
    <div class="bg-neutral-900 text-white shadow-sharp border-2 border-opacity-50 border-white flex-col h-full w-96 flex place-items-center rounded-2xl">
        <h2 class="p-5 pb-2 font-bold text-xl">Wat is jouw discord token?</h2>
        <h3 class="text-sm text-gray-300 text-center">Token wordt alleen lokaal opgeslagen</h3>
        <h3 class="text-sm text-gray-300 text-center">ik kan de token niet zien</h3>
        <div class="">
            {#if seeTokenToggle}
                <p on:select={(e) => e.preventDefault()} on:click={seeToken}
                   class="cursor-pointer select-auto absolute top-1/2 transform translate-y-1 right-14 text-xl">
                    🙉️</p>
            {:else}
                <p on:select={(e) => e.preventDefault()} on:click={seeToken}
                   class="cursor-pointer absolute top-1/2 transform translate-y-1 right-14 text-xl">🙈</p>
            {/if}
            <input id="tokenInput" type="password" class="text-xl m-5 w-10/12 p-2 bg-neutral-800 rounded-lg"
                   placeholder="Discord token">
        </div>

        <button class="bg-red-600 mb-5 p-2 px-7 rounded-lg hover:scale-105 active:scale-100 transition-all transform-gpu duration-100"
                on:click={updateToken}>voeg token toe
        </button>
    </div>
</div>