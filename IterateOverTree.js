/*
Iterate over a tree structure
Iterate down each branch of the tree and log the property
*/

let person = {
  name: "Root",
  father: {
    name: "Root's Father",
    father: {
      name: "Root's Paternal Grandfather",
      father: {
        name: "Root's Paternal Great-Grandfather 1"
      },
      mother: {
        name: "Root's Paternal Great-Grandmother 1"
      }
    },
    mother: {
      name: "Root's Paternal Grandmother",
      father: {
        name: "Root's Paternal Great-Grandfather 2"
      },
      mother: {
        name: "Root's Paternal Great-Grandmother 2"
      }
    },
  },
  mother: {
    name: "Roots' Mother",
    father: {
      name: "Root's Maternal Grandfather",
      father: {
        name: "Root's Maternal Great-Grandfather 1"
      },
      mother: {
        name: "Root's Maternal Great-Grandmother 1"
      }
    },
    mother: {
      name: "Root's Maternal Grandmother",
      father: {
        name: "Root's Maternal Great-Grandfather 1"
      },
      mother: {
        name: "Root's Maternal Great-Grandmother 1"
      }
    }
  }
};

/*

Base case:
The current node has a name, but no `mother` or `father` property

Recursive case:
The current node has a `mother` and/or `father` property

Task 0: For each person whose parents are in the family tree, log their name and the name of their parents.

Task 1: Return an array of all the members of the family, starting from root up the family tree, going by branch.

Task 2: Return an array of all the members of the family, starting from root up the family tree, going by generation

*/

function logFamilyTreeByBranch(familyTreeBranch) {
  // Base case
  if (familyTreeBranch.father === undefined && familyTreeBranch.mother === undefined) {
    return;
  }
  // Recursive case
  else if (familyTreeBranch.mother || familyTreeBranch.father) {
    console.log(`This family member is ${familyTreeBranch.name}. Their father is ${familyTreeBranch.father.name}. Their mother is ${familyTreeBranch.mother.name}.`);
    familyTreeBranch.father && logFamilyTreeByBranch(familyTreeBranch.father);
    familyTreeBranch.mother && logFamilyTreeByBranch(familyTreeBranch.mother);
  }
}

logFamilyTreeByBranch(person);

