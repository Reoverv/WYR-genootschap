<script lang="ts">
    import "./app.css"

    import CardList from "./lib/Cards/CardList.svelte";
    import Searchbar from "./lib/Searchbar.svelte";
    import Title from "./lib/Title.svelte";
    import Nav from "./lib/Navigation/Nav.svelte";
    import InputToken from "./lib/Components/InputToken.svelte";

    import {onMount} from "svelte";
    import {askToken} from "./lib/stores/tokenStore";


    let blur = true

    onMount(() => {
        blur = checkToken()
        if (localStorage.getItem("askToken") === "false") {
            blur = false

        }
    })


    function checkToken() {
        let regex = /^.*\..*(\d([A-Za-z]+\d)+).*$/gm
        let token = localStorage.getItem("DiscordToken")
        if (token === null) {
            return true
        }

        return !(token.length > 50 && token !== null && regex.test(token));

    }

</script>

<div class="bg-neutral-900 h-screen transition-all">
    <div class={blur ? "flex blur" : "flex flex-col"}>
        <div class="flex">
            <Title/>
            <Searchbar/>
        </div>
        <div class="flex">
            <Nav/>
            <CardList/>
        </div>
    </div>
    {#if blur}
        <InputToken {blur}/>
    {/if}
</div>


<style lang="postcss"></style>