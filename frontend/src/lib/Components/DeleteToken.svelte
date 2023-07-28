<script>


    import {askToken} from "../stores/tokenStore.js";

    function deleteToken() {
        localStorage.setItem("DiscordToken", "")

        localStorage.setItem("askToken", !document.getElementById("checkbox").checked)

    }

    function check() {
        let checkbox = document.getElementById("checkbox")
        let bool = checkbox.checked

        checkbox.checked = !bool

    }

</script>

<div class="place-items-center absolute top-1/2 left-1/2 transform -translate-x-1/2 -translate-y-1/2">
    <div class="bg-neutral-900 text-white shadow-sharp border-2 border-opacity-50 border-white flex-col h-full w-96 flex place-items-center rounded-2xl">
        <h2 class="select-none p-5 pb-2 font-bold text-2xl text-center">Weet je zeker dat je jouw token wilt
            verwijderen?</h2>


        <div on:click={() => check()} class="flex self-start m-5 ml-0">
            <input id="checkbox" type="checkbox" class="mx-3 ml-5">
            <h3 class="select-none text-lg font-normal">Vraag niet meer om mijn token</h3>
        </div>


        <button class="bg-red-600 mb-5 p-2 px-7 rounded-lg hover:scale-105 active:scale-100 transition-all transform-gpu duration-100"
                on:click={deleteToken}>Verwijder token
        </button>
    </div>
</div>