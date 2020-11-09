import React from 'react';

const Overview = (props) => {
    return (
        <div className="col-md-8 d-flex " style={columnStyle}>
            <div className="justify-content-center align-self-center" style={divStyle}>
                {props.overview}
            </div>
        </div>
    );
}

const columnStyle = {
    height: "300px",
    width: "100%",
    color: "white",
    backgroundColor: "#2e2e2e",
    textAlign: "justify",
}

const divStyle = {
    marginLeft: "10%", lineHeight: "150%"
}

export default Overview;