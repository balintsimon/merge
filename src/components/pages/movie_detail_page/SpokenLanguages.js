import React from 'react';

const SpokenLanguages = (props) => {

  const enumerateLanguages = (languages) => {
    return languages.filter(language => language !== "").join(", ");
  }

  return (
      <div
          className="col-md-12 d-flex justify-content-center align-content-center flex-wrap"
          style={columnStyle}>
        <div style={divStyle}>
          <p style={{opacity: "0.8", filter: "blur(0.3px)", fontSize: "80%"}}>Spoken language(s):</p>
          <p>{enumerateLanguages(props.spokenLanguages)}</p>
        </div>
      </div>
  );
}

const columnStyle = {
  height: "150px", backgroundColor: "#2e2e2e"
}

const divStyle = {
  fontStyle: "italic",
  fontSize: "20px",
  color: "white",
  textAlign: "center"
}

export default SpokenLanguages;