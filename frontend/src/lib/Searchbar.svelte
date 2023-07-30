<script>
    import Fa from 'svelte-fa/src/fa.svelte'
    import {faMagnifyingGlass} from "@fortawesome/free-solid-svg-icons";


    let innerWidth
</script>
<svelte:window bind:innerWidth/>

{#if innerWidth > 640}
    <div class="rounded-s-2xl my-4 text-[1.75rem] w-full bg-neutral-5100">

        <input class="focus:outline-none bg-neutral-800 w-full rounded-s-2xl pl-4 py-2  text-white" type="text"
                  placeholder="Zoek naar wyr+ content">


    </div>
{:else}
    <div class="rounded-2xl mr-5 w-fit  scale-90 my-5 p-5 text-[1.75rem] bg-neutral-800">
        <Fa style="color:gray" icon={faMagnifyingGlass}/>
    </div>

{/if}


