<template>
  <div class='calculator' onselectstart='return false'>
    <div class='display'>{{ display }}</div>
    <div @click='clear' class='button darker c'>C</div>
    <div @click='sign' class='button darker'>+/-</div>
    <div @click='divide' class='button operator'>÷</div>
    <div @click='append(7)' class='button'>7</div>
    <div @click='append(8)' class='button'>8</div>
    <div @click='append(9)' class='button'>9</div>
    <div @click='multiply' class='button operator'>x</div>
    <div @click='append(4)' class='button'>4</div>
    <div @click='append(5)' class='button'>5</div>
    <div @click='append(6)' class='button'>6</div>
    <div @click='subtract' class='button operator'>-</div>
    <div @click='append(1)' class='button'>1</div>
    <div @click='append(2)' class='button'>2</div>
    <div @click='append(3)' class='button'>3</div>
    <div @click='add' class='button operator'>+</div>
    <div @click='append(0)' class='button zero button-bottom'>0</div>
    <div @click='decimal' class='button darker button-bottom'>.</div>
    <div @click='equal' class='button operator button-bottom'>=</div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      previous: null,
      display: 0,
      operator: null,
      operatorClicked: false,
      action: null
    };
  },
  methods: {
    clear() {
      this.display = 0;
      axios.delete("http://localhost:8080/api/calculations/calc")
    },
    sign() {
      this.display =
          this.display < 0
              ? (this.display = this.display - this.display * 2)
              : (this.display = this.display - this.display * 2);
    },
    append(number) {
      if (this.operatorClicked === true) {
        this.display = '';
        this.operatorClicked = false;
      }
      this.display =
          this.display === 0
              ? (this.display = number)
              : '' + this.display + number;
    },
    decimal() {
      if (this.display.indexOf('.') === -1) {
        this.append('.');
      }
    },
    divide() {
      return new Promise(resolve => {
        this.action = "division"
        resolve(this.operator = (a, b) =>
            axios.post('http://localhost:8080/api/calculations/calc', {
              firstNumber: a,
              secondNumber: b,
              action: this.action
            }));
        this.previous = this.display;
        this.operatorClicked = true;
      })
    },
    multiply() {
      return new Promise(resolve => {
        this.action = "multi"
        resolve(this.operator = (a, b) =>
            axios.post('http://localhost:8080/api/calculations/calc', {
              firstNumber: a,
              secondNumber: b,
              action: this.action
            }));
        this.previous = this.display;
        this.operatorClicked = true;
      })
    },
    subtract() {
      return new Promise(resolve => {
        this.action = "minus"
        resolve(this.operator = (a, b) =>
            axios.post('http://localhost:8080/api/calculations/calc', {
              firstNumber: a,
              secondNumber: b,
              action: this.action
            }));
        this.previous = this.display;
        this.operatorClicked = true;
      })
    },
    add() {
      return new Promise(resolve => {
        this.action = "plus"
        resolve(this.operator = (a, b) =>
            axios.post('http://localhost:8080/api/calculations/calc', {
              firstNumber: a,
              secondNumber: b,
              action: this.action
            }));
        this.previous = this.display;
        this.operatorClicked = true;
      })

    },
    async equal() {
      await this.operator(Number(this.previous), Number(this.display));
      axios.get("http://localhost:8080/api/calculations/calc")
          .then(response => {
            this.display = response.data;
          })
      /*this.display = */
      this.previous = null;
      this.operatorClicked = true;
    }
  }
};
</script>

<style scoped>
.calculator {
  margin: 0 auto;
  width: 80vw;
  font-size: 2rem;
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  grid-auto-rows: minmax(10vh, auto);
  border: 5px solid #111;
  box-shadow: -3px 3px 15px rgba(10, 10, 10, 0.4);
  line-height: 10vh;
}

.display {
  grid-column: 1 / 5;
  background: white;
  border: 1px solid #111;
  border-top: 0;
  font-size: 2.5rem;
  cursor: default;
  overflow: hidden;
  text-overflow: ellipsis;
  padding: 0 1rem;
}

.zero {
  grid-column: 1 / 3;
}

.button {
  background: hsl(0, 0%, 99%);
  background: linear-gradient(15deg, hsl(0, 0%, 80%) 0%, hsl(0, 0%, 99%) 100%);
  border: 1px solid #111;
  display: flex;
  justify-content: center;
  align-items: center;
  cursor: pointer;
}
.c {
  grid-column:  1 / 3;
}
.button:active {
  outline: none;
  border: 1px solid #000000BF;
  box-shadow: inset 0px 0px 5px #00000080;
  -moz-box-shadow: inset 0px 0px 5px #00000080;
  -webkit-box-shadow: inset 0px 0px 5px #00000080;
}

.button-bottom {
  border-bottom: 0;
}

.operator {
  background: rgb(255,147,5);
}

.darker {
  background: hsl(0, 0%, 90%);
  background: linear-gradient(15deg, hsl(0, 0%, 70%) 0%, hsl(0, 0%, 90%) 100%);
}

@media only screen and (min-width: 768px) {
  .calculator {
    width: 50vw;
    grid-auto-rows: minmax(7.5vh, auto);
    line-height: 7.5vh;
  }
}

@media only screen and (min-width: 1024px) {
  .calculator {
    width: 30vw;
  }
}

@media only screen and (min-width: 1280px) {
  .calculator {
    width: 20vw;
  }
}

@media only screen and (min-width: 1600px) {
  .calculator {
    width: 15vw;
  }
}
</style>
