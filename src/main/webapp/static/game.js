function loadQuestion(){
fetch('/game')
  .then((response) => {
    return response.json();
  })
  .then((data) => {
    const myDiv1 = document.getElementById('question');
    myDiv1.textContent = data.question;
    const myDiv2 = document.getElementById('choice');
    myDiv2.innerHTML = '';
    data.choices.forEach((choice) => {
        const button = document.createElement('button');
        button.textContent = choice.text;
        myDiv2.appendChild(button);
    button.onclick = function() {
    fetch('/game', {
        method: 'POST',
        body: new URLSearchParams({nextStepId: choice.nextStepId})
    }).then(() => loadQuestion());
    };
  });
  });
};
loadQuestion();