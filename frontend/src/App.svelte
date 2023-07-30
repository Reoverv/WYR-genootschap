<script lang="ts">
    import "./app.css"

    import CardList from "./lib/Cards/CardList.svelte";
    import Searchbar from "./lib/Searchbar.svelte";
    import Title from "./lib/Title.svelte";
    import Nav from "./lib/Navigation/Nav.svelte";
    import InputToken from "./lib/Components/InputToken.svelte";

    import {onMount} from "svelte";
    import {askToken} from "./lib/stores/tokenStore";

    let innerWidth = 0
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

<svelte:window bind:innerWidth/>

<div class="bg-neutral-900 h-screen transition-all">
    <div class={blur ? "flex blur" : "flex"}>
        <div class="flex flex-col ">

            <Title/>

            <Nav/>


        </div>
        <div class="grid w-full grid-cols-3">
            <div class="xs:justify-self-end md:justify-self-stretch col-span-3">
                <Searchbar/>
            </div>
            <div class="col-span-3">
                <CardList/>
            </div>
        </div>
    </div>
    {#if blur}
        <InputToken {blur}/>
    {/if}
</div>


<style lang="postcss"></style>