<script>
    import DeleteToken from "../Components/DeleteToken.svelte";
    import Fa from 'svelte-fa'
    import {faHouse} from '@fortawesome/free-solid-svg-icons'

    let deleteToken = false

    let innerWidth = 0
    let innerHeight = 0

    $: condition = innerWidth >= 800

    let NavItems = [
        "Home",
        "Would you rather",
        "more or less",
        "Smash or pass",
        "Stats",
        "Verwijder token"
    ]

    let NavSvg = [
        "fa-house"
    ]

    let currentActive = 1

    function changeCurrentActive(index) {
        currentActive = index

    }

    function setDeleteToken(index) {
        deleteToken = index === NavItems.length - 1;
    }


</script>


<svelte:window bind:innerWidth bind:innerHeight/>

{#if condition}
    <div class=" text-white ml-3 w-96  mt-10 text-2xl font-sans mr-10 font-semibold  cursor-pointer">
        {#each NavItems as item, i}


            <div on:click={() => changeCurrentActive(i)} class={currentActive !== i ? "flex place-items-center p-2 mb-6 text-neutral-300" : "place-items-center flex p-2 mb-6 rounded-2xl border-2 border-opacity-50 border-white bg-neutral-800"}>
                <Fa icon={faHouse}/>
                <p on:click={() => setDeleteToken(i)} class="pl-5">{item}</p>
            </div>
        {/each}

        {#if deleteToken}
            <DeleteToken/>
        {/if}
    </div>
{/if}