// Hardcoded recipes array (instead of fetching from an API)
const recipes = [
    {
        name: "Vegan Buddha Bowl",
        description: "A colorful and healthy vegan bowl filled with vegetables, quinoa, and tahini dressing.",
        category: "Vegan",
        prepTime: 25
    },
    {
        name: "Grilled Chicken Salad",
        description: "A refreshing salad with grilled chicken, mixed greens, tomatoes, and a light vinaigrette.",
        category: "Paleo",
        prepTime: 20
    },
    {
        name: "Gluten-Free Pancakes",
        description: "Fluffy gluten-free pancakes made with almond flour and topped with fresh berries.",
        category: "Gluten-Free",
        prepTime: 15
    },
    {
        name: "Quinoa Stir Fry",
        description: "A quick stir fry with quinoa, tofu, vegetables, and soy sauce.",
        category: "Vegetarian",
        prepTime: 30
    }
];

// Function to render recipe cards on the page
function renderRecipes() {
    const recipeList = document.getElementById('recipe-list');
    recipeList.innerHTML = ''; // Clear any existing content

    recipes.forEach(recipe => {
        const card = document.createElement('div');
        card.classList.add('recipe-card');

        card.innerHTML = `
            <h3>${recipe.name}</h3>
            <p>${recipe.description}</p>
            <p><strong>Category:</strong> ${recipe.category}</p>
            <p><strong>Prep Time:</strong> ${recipe.prepTime} minutes</p>
        `;

        recipeList.appendChild(card);
    });
}

// Call the renderRecipes function when the page loads
window.onload = renderRecipes;
