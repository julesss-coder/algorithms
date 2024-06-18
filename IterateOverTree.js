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

function listFamilyMembersByBranch(familyTreeBranch) {
  let members = [];

  // Base case
  if (familyTreeBranch.father === undefined && familyTreeBranch.mother === undefined) {
    members.push(familyTreeBranch.name);
    return members;
  }
  // Recursive cases
  if (familyTreeBranch.father) {
    members.push(familyTreeBranch.name);
    members = members.concat(listFamilyMembersByBranch(familyTreeBranch.father));
  }

  if (familyTreeBranch.mother) {
    members.push(familyTreeBranch.name);
    members = members.concat(listFamilyMembersByBranch(familyTreeBranch.mother));
  }

  return members;
}

let familyMembersByBranch = listFamilyMembersByBranch(person);
console.log(familyMembersByBranch);
/*

TRACE

1st call: members = members.concat()

*/

function getFamilyTreeByBranch(familyTreeBranch) {
  let names = []; // Step 1: Define an array to hold names

  // Base case
  if (familyTreeBranch.father === undefined && familyTreeBranch.mother === undefined) {
    names.push(familyTreeBranch.name); // Collect name
  }
  // Recursive case
  else {
    names.push(familyTreeBranch.name); // Collect name
    if (familyTreeBranch.father) {
      names = names.concat(getFamilyTreeByBranch(familyTreeBranch.father)); // Merge arrays
    }
    if (familyTreeBranch.mother) {
      names = names.concat(getFamilyTreeByBranch(familyTreeBranch.mother)); // Merge arrays
    }
  }

  return names; // Return the array of names
}

// Example usage
const familyNames = getFamilyTreeByBranch(person);
console.log(familyNames);