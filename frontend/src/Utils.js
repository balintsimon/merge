import {DAYS} from "./Constants";

export const getIdFromUrl = () => {
  let urlFragments = window.location.href.split("/");
  return urlFragments[urlFragments.length - 1];
};

export const limitString = (inputString, titleString) => {
  let overviewCharacterLimit = 180 - titleString.length * 2;
  let outputString = "No overview available.";
  if (inputString.length > overviewCharacterLimit) {
    for (let i = 0; i < inputString.length - overviewCharacterLimit; i++) {
      if (inputString.charAt(overviewCharacterLimit + i) === " ") {
        return inputString.substring(0, overviewCharacterLimit + i) + " ...";
      }
    }
  } else {
    outputString = inputString;
  }

  return outputString;
}

export const limitNameString = (nameString, limit) => {
  if (nameString.length > limit) {
    return `${nameString.substring(0, limit)}...`;
  } else {
    return nameString;
  }
}

export const checkStatus = (response) => {
  if (response.ok) {
    return Promise.resolve(response);
  } else {
    return Promise.reject(new Error(response.statusText));
  }
}

export const parseJSON = (response) => {
  return response.json();
}

export const getDayNameFromDate = (date) => {
  const dateObject = new Date(date);
  return DAYS[dateObject.getDay()];
};

export const formatTime = (time) => {
  let timeParts = time.split(":");
  return `${timeParts[0]}:${timeParts[1]}`;
};

export const getYearFromDate = (releaseDate) => {
  let year = releaseDate.split("-")[0];
  if (year === "") {
    return "";
  } else {
    return ` (${year})`;
  }
};

export const formatDateWithDecimals = (date) => {
  return date.split("-").join(".");
};

export const getAgeIfActorAlive = birthDate => Math.floor((new Date() - new Date(birthDate).getTime()) / 3.15576e+10);
export const getAgeIfActorDead = (deathDate, birthDate) => Math.floor((new Date(deathDate) - new Date(birthDate).getTime()) / 3.15576e+10);