<script>


    let NavItems = [
        "Home",
        "Would you rather",
        "Most likely to",
        "Smash or pass",
        "Stats"
    ]

    let currentActive = 1

    function changeCurrentActive(index) {
        currentActive = index
    }


</script>


<div class="text-white ml-3 mt-10 text-2xl font-sans font-semibold  w-full cursor-pointer">

    {#each NavItems as item, i}
        <div on:click={() => changeCurrentActive(i)} class="flex">
            <p class={currentActive === i ? "p-2 mb-6 rounded-2xl border-2 border-opacity-50 border-white bg-neutral-800" : "p-2 mb-6 text-neutral-300"}>{item}</p>
        </div>

    {/each    }

</div>